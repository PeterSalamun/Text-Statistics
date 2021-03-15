package appLogicTests.TextOperationsTests;

import appLogicTests.TextOperations.Frequency;
import org.apache.commons.math3.util.Precision;
import org.apache.poi.hssf.record.CFRule12Record;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FrequencyTest {

    String s1, s2, s3, s4;
    TreeMap<String, Double> treeMap;

    @Before
    public void setUp() {
        s1 = "ahoj";
        s2 = "Ahoj svet.";
        s3 = "";
        s4 = " ";
    }

    private TreeMap<String, Double> fillMap(String str, String cond) {
        double total = 0;
        TreeMap<String, Double> map = new TreeMap<>();
        String temp = "";
        Double count;
        for(int i  = 0; i < str.length(); i++){
            temp = Character.toString(str.charAt(i)).toLowerCase();
            if(!temp.equals(cond)){
                total++;
                if(map.containsKey(temp)){
                    count = map.get(temp);
                    map.put(temp, ++count);
                } else{
                    map.put(temp, 1.0);
                }
            }
        }
        System.out.println(total);
        for(String s: map.keySet()) {
            double value = percentage(map.get(s), total);
            map.put(s, value);
        }
        return map;
    }

    private double round(double number, int decimalPlaces) {
        if (Double.isNaN(number))
            return 0.0;
        return Precision.round(number, decimalPlaces, 4);
    }

    private double percentage(double value1, double value2) {
        return round((value1 / value2) * 100, 2);
    }

    @Test
    public void getFrequencyWithoutSpaceTest() {
        String cond = " ";
        Frequency fr1 = new Frequency();
        fr1.addSentence(s1);
        treeMap = fillMap(s1, cond);
        assertTrue(fr1.getFrequencyWithoutSpace().equals(treeMap));

        Frequency fr2 = new Frequency();
        fr2.addSentence(s2);
        treeMap = fillMap(s2, cond);
        assertTrue(fr2.getFrequencyWithoutSpace().equals(treeMap));

        Frequency fr3 = new Frequency();
        fr3.addSentence(s3);
        treeMap = fillMap(s3, cond);
        assertTrue(fr3.getFrequencyWithoutSpace().equals(treeMap));

        Frequency fr4 = new Frequency();
        fr4.addSentence(s4);
        treeMap = fillMap(s4, cond);
        assertTrue(fr4.getFrequencyWithoutSpace().equals(treeMap));
    }

    @Test
    public void getFrequencyWithSpaceTest() {
        String cond = null;
        Frequency fr1 = new Frequency();
        fr1.addSentence(s1);
        treeMap = fillMap(s1, cond);
        assertTrue(fr1.getFrequencyWithSpace().equals(treeMap));

        Frequency fr2 = new Frequency();
        fr2.addSentence(s2);
        treeMap = fillMap(s2, cond);
        assertTrue(fr2.getFrequencyWithSpace().equals(treeMap));

        Frequency fr3 = new Frequency();
        fr3.addSentence(s3);
        treeMap = fillMap(s3, cond);
        assertTrue(fr3.getFrequencyWithSpace().equals(treeMap));

        Frequency fr4 = new Frequency();
        fr4.addSentence(s4);
        treeMap = fillMap(s4, cond);
        assertTrue(fr4.getFrequencyWithSpace().equals(treeMap));
    }
}
