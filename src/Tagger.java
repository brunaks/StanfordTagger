import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class Tagger {

    public static void main(String args[]) {

        MaxentTagger tagger = new MaxentTagger("taggers/english-bidirectional-distsim.tagger");
        String sample = "She looked at him";

        Long initial_time = System.nanoTime();
        String taggedSample = tagger.tagString(sample);
        Long final_time = System.nanoTime();
        System.out.println("Total time: " + String.valueOf((final_time - initial_time)/1000000));

        System.out.println(taggedSample);


    }
}
