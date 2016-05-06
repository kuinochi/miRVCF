package c4Lab;

/**
 * This is the VCF reader
 *
 * Created by dungchi on 5/6/16.
 */


import htsjdk.variant.variantcontext.VariantContext;
import htsjdk.variant.vcf.VCFCodec;
import htsjdk.tribble.readers.LineIterator;
import htsjdk.tribble.readers.LineIteratorImpl;
import htsjdk.tribble.readers.LineReaderUtil;
import htsjdk.variant.vcf.VCFHeader;
import htsjdk.variant.variantcontext.Allele;

import java.io.*;
import java.util.*;


public class VCFReader {


    public static void main(String[] args) throws IOException {
        long startTime;
        startTime = System.currentTimeMillis();

        final String inVCF = args[0];


        // Read input VCF

        // Variables

        // Input file
        BufferedReader schemaReader = new BufferedReader(new FileReader(inVCF));

        // VCF decoder
        VCFCodec vcfCodec = new VCFCodec();

        // Input file line
        String line;

        // Input file -- VCF header line
        String headerLine = "";

        // Input file -- VCF content line
        VariantContext vctx;

        // Read file
        while ((line = schemaReader.readLine()) != null) {

            //  Header starts with comment sign
            if (line.startsWith("#")) {

                // Concatenate all the header line into a string
                headerLine = headerLine.concat(line).concat("\n");
                continue;
            }

            // Append header to decoder
            vcfCodec.readActualHeader(
                    new LineIteratorImpl(
                            LineReaderUtil.fromStringReader(
                                    new StringReader(headerLine), LineReaderUtil.LineReaderOption.SYNCHRONOUS
                            )
                    )
            );


            // Read Variant
            if(!line.startsWith("#")) {

                // Decode variant
                vctx = vcfCodec.decode(line);

                //
                System.out.println("Locus: chr" + vctx.getContig()+ " start: " + vctx.getStart() + ", end: " + vctx.getEnd());

                //
                if(vctx.getAlternateAlleles().get(0).length()>100)
                    System.out.println(" length: "+vctx.getAlternateAlleles().get(0).length()+" ref: "+vctx.getReference() +
                            " alt:" + vctx.getAlternateAlleles().get(0) + " GT: " +
                            vctx.getGenotype(vctx.getSampleNamesOrderedByName().get(0)).getGenotypeString() );

            }

        }
    }
}
