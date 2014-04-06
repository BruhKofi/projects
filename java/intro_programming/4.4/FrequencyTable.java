public class FrequencyTable
{
    private BST<String, Integer> st = new BST<String, Integer>();
    
    public void click(String s) {
        if (st.contains(s)) st.put(s, st.get(s)+1);
        else st.put(s, 1);
    }

    public int count(String s) {
        if (!st.contains(s)) return 0;
        return st.get(s);
    }

    public static void main(String[] args) {
        FrequencyTable fq = new FrequencyTable();

        fq.click("hello");
        fq.click("hello");
        fq.click("world");

        StdOut.println(fq.count("hello") + " " + fq.count("world") + " " + fq.count("none"));
    }
}
        
