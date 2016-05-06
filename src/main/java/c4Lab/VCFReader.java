/**
 * This is a VCF reader
 *
 * Created by dungchi on 5/6/16.
 */

package c4Lab;

import htsjdk.variant.vcf.VCFCodec;
import java.io.*;
import java.util.*;


public class VCFReader {


    public static void main( String[] args ) throws IOException {
        long startTime;
        startTime = System.currentTimeMillis();
        VCFCodec vcfCodec = new VCFCodec();
        FileWriter out = new FileWriter("");
        System.out.println(startTime);

    }
}
