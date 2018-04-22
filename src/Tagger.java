import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tagger {

    public static void main(String args[]) throws IOException {

        MaxentTagger tagger = new MaxentTagger("taggers/english-bidirectional-distsim.tagger");

        List<String> filenames = Arrays.asList(
                "w_acad_1990.txt",
                "w_acad_1991.txt",
                "w_acad_1992.txt",
                "w_acad_1993.txt",
                "w_acad_1994.txt",
                "w_acad_1995.txt",
                "w_acad_1996.txt",
                "w_acad_1997.txt",
                "w_acad_1998.txt",
                "w_acad_1999.txt",
                "w_acad_2000.txt",
                "w_acad_2001.txt",
                "w_acad_2002.txt",
                "w_acad_2003.txt",
                "w_acad_2004.txt",
                "w_acad_2005.txt",
                "w_acad_2006.txt",
                "w_acad_2007.txt",
                "w_acad_2008.txt",
                "w_acad_2009.txt",
                "w_acad_2010.txt",
                "w_acad_2011.txt",
                "w_acad_2012.txt",
                "w_fic_1990.txt",
                "w_fic_1991.txt",
                "w_fic_1992.txt",
                "w_fic_1993.txt",
                "w_fic_1994.txt",
                "w_fic_1995.txt",
                "w_fic_1996.txt",
                "w_fic_1997.txt",
                "w_fic_1998.txt",
                "w_fic_1999.txt",
                "w_fic_2000.txt",
                "w_fic_2001.txt",
                "w_fic_2002.txt",
                "w_fic_2003.txt",
                "w_fic_2004.txt",
                "w_fic_2005.txt",
                "w_fic_2006.txt",
                "w_fic_2007.txt",
                "w_fic_2008.txt",
                "w_fic_2009.txt",
                "w_fic_2010.txt",
                "w_fic_2011.txt",
                "w_fic_2012.txt",
                "w_mag_1990.txt",
                "w_mag_1991.txt",
                "w_mag_1992.txt",
                "w_mag_1993.txt",
                "w_mag_1994.txt",
                "w_mag_1995.txt",
                "w_mag_1996.txt",
                "w_mag_1997.txt",
                "w_mag_1998.txt",
                "w_mag_1999.txt",
                "w_mag_2000.txt",
                "w_mag_2001.txt",
                "w_mag_2002.txt",
                "w_mag_2003.txt",
                "w_mag_2004.txt",
                "w_mag_2005.txt",
                "w_mag_2006.txt",
                "w_mag_2007.txt",
                "w_mag_2008.txt",
                "w_mag_2009.txt",
                "w_mag_2010.txt",
                "w_mag_2011.txt",
                "w_mag_2012.txt",
                "w_news_1990.txt",
                "w_news_1991.txt",
                "w_news_1992.txt",
                "w_news_1993.txt",
                "w_news_1994.txt",
                "w_news_1995.txt",
                "w_news_1996.txt",
                "w_news_1997.txt",
                "w_news_1998.txt",
                "w_news_1999.txt",
                "w_news_2000.txt",
                "w_news_2001.txt",
                "w_news_2002.txt",
                "w_news_2003.txt",
                "w_news_2004.txt",
                "w_news_2005.txt",
                "w_news_2006.txt",
                "w_news_2007.txt",
                "w_news_2008.txt",
                "w_news_2009.txt",
                "w_news_2010.txt",
                "w_news_2011.txt",
                "w_news_2012.txt",
                "w_spok_1990.txt",
                "w_spok_1991.txt",
                "w_spok_1992.txt",
                "w_spok_1993.txt",
                "w_spok_1994.txt",
                "w_spok_1995.txt",
                "w_spok_1996.txt",
                "w_spok_1997.txt",
                "w_spok_1998.txt",
                "w_spok_1999.txt",
                "w_spok_2000.txt",
                "w_spok_2001.txt",
                "w_spok_2002.txt",
                "w_spok_2003.txt",
                "w_spok_2004.txt",
                "w_spok_2005.txt",
                "w_spok_2006.txt",
                "w_spok_2007.txt",
                "w_spok_2008.txt",
                "w_spok_2009.txt",
                "w_spok_2010.txt",
                "w_spok_2011.txt",
                "w_spok_2012.txt" );

        for (String filename : filenames) {

            String fullText = "";
            try (BufferedReader br = new BufferedReader(new FileReader("COCA-samples/" + filename))) {

                String currentLine;
                while ((currentLine = br.readLine()) != null) {
                    fullText = fullText.concat("\n");
                    fullText = fullText.concat(currentLine);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            //System.out.println(fullText);
            //Long initial_time = System.nanoTime();

            String taggedSample = tagger.tagString(fullText);
            Long final_time = System.nanoTime();

            //System.out.println("Total time: " + String.valueOf((final_time - initial_time) / 1000000));
            //System.out.println(taggedSample);

            BufferedWriter writer = new BufferedWriter(new FileWriter("COCA-samples-output/" + filename));
            writer.write(taggedSample);
            writer.close();
        }

    }
}
