/**
 * This is a VCF reader
 *
 * Created by dungchi on 5/6/16.
 */

package c4Lab;

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
        BufferedReader schemaReader = new BufferedReader(new FileReader(inVCF));
        VCFCodec vcfCodec = new VCFCodec();
        String line;
        String headerLine = "";
        VariantContext vctx;
        while ((line = schemaReader.readLine()) != null) {

            // Header line start with comment sign
            if (line.startsWith("#")) {
                headerLine = headerLine.concat(line).concat("\n"); // concatenate all the header line
                continue;
            }

            //VCFHeader header =;
            //vcfCodec.readActualHeader(new LineIteratorImpl(LineReaderUtil.fromStringReader(
            //        new StringReader(headerLine), LineReaderUtil.LineReaderOption.SYNCHRONOUS)));

            /*
            // Variant is stored line by line
            if(!line.startsWith("#")) {
                vctx = vcfCodec.decode(line);
                if(vctx.getAlternateAlleles().get(0).length()>100)
                    System.out.println(" length: "+vctx.getAlternateAlleles().get(0).length()+" ref: "+vctx.getReference() +
                            " alt:" + vctx.getAlternateAlleles().get(0) + " GT: " +
                            vctx.getGenotype(vctx.getSampleNamesOrderedByName().get(0)).getGenotypeString() );


            }
*/
        }
        System.out.print(headerLine);
    }
}
