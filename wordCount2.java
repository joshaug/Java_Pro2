
    
 public class wordCount2 implements Comparable<wordCount2>{
    private String word;
    private Integer count;
    private String name;
    public wordCount2(String word){
        this.word = word;
        
        
    }

    public wordCount2(int count,String name, String word){
        this.name = name;
        this.word = word;
        this.count = count;
        
    }
    public String getword(){
        return this.word;
    }
    public void setword(String word){
        this.word = word;
    }
     public String getname(){
        return this.name;
    }
    public void setname(String name){
        this.name = name;
    }
    public Integer getcount(){
        return this.count;
    }
    public void setcount(Integer count){
        this.count = count;
    }
    public int compareTo(wordCount2 other){
        return this.count - other.count;
    }
    
    
    public String toString() {
        return this.word+" "+this.count+"\n";
        //return(this.name + "%63s") + "\t" + (this.word + "%63s") + "\t" + this.count+"\n";
        //return String.format("%63s\t%63s\t%10d", name, word, count);
    }
}   
    