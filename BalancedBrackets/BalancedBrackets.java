package BalancedBrackets;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
/*
 *
 * Author: Abhilash GD
 * Class to Find whether nested brackets are balanced or not
 *
 */
public class BalancedBrackets {
    /*
    Private Instance variables
     */
    private String bracketString;
    private String yes="true";
    private String no="false";
    private final HashSet<Integer> indexSet = new HashSet<Integer>();
    /*
     *method to take input and print output
     */
    private void checkBalance() {
        System.out.println("Enter Number of Test Cases");

        int testCaseNumber=nextInt();
        OutputBuilder outPut = new OutputBuilder();
        System.out.println("Enter the brackets strings for each test case");
        while(testCaseNumber-->0){
            outPut.setOutput(isBalanced(nextLine()));
            indexSet.clear(); //clears the hashset after every test case.
        }
        outPut.getOutput();
    }
    /*
     *method to check brackets are balanced or not
     */
    public String isBalanced(String bracketString) {
        this.bracketString=bracketString;
        boolean bracketFound=false;
        for(int i=0;i<bracketString.length();i++){
            char ch = bracketString.charAt(i);
            if(ch=='('|| ch=='['|| ch=='{'){
                if(FindPair(ch,i)){bracketFound=true;}
                else{bracketFound=false;break;}

            }else if(indexSet.contains(i)){
                continue;
            }else{bracketFound=false;break;}
        }
        if(bracketFound) return yes;
        else return no;
    }
    /*
     * method to find the corresponding pair of an element inside the brackets string
     */
    private boolean FindPair(char ch, int i) {
        boolean pairFound=false;
        if(ch=='('){
            for(int j=i+1;j<bracketString.length();j++){
                if(bracketString.charAt(j)==')'){
                    if(indexSet.isEmpty()||!indexSet.contains(j)){
                        indexSet.add(j);pairFound=true;break;
                    }
                    else{continue;}
                }
            }
        }
        else if(ch=='['){
            for(int j=i+1;j<bracketString.length();j++){
                if(bracketString.charAt(j)==']'){
                    if(indexSet.isEmpty()||!indexSet.contains(j)){
                        indexSet.add(j);pairFound=true;break;
                    }
                    else{continue;}
                }
            }
        }
        else if(ch=='{'){
            for(int j=i+1;j<bracketString.length();j++){
                if(bracketString.charAt(j)=='}'){
                    if(indexSet.isEmpty()||!indexSet.contains(j)){
                        indexSet.add(j);pairFound=true;break;
                    }
                    else{continue;}
                }
            }
        }
        return pairFound;
    }
    /* Utility Class to build the output */
    class OutputBuilder{
        private StringBuilder sb =new StringBuilder();

        void setOutput(String val){
            sb.append(val+"\n");
        }
        void getOutput(){
            pw.println(sb.toString());
        }


    }
    /*
     * main method to set all initialisers and calls checkBalance method
     */

    public static void main(String[] args) throws Exception { new BalancedBrackets().run(); }

    InputStream is;
    PrintWriter pw;
    String INPUT = "";
    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        checkBalance();
        pw.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }
    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }
    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private boolean isSpaceString(int c){return !(c >= 32 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

    private String nextLine() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceString(b))){ // when nextLine)
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private int nextInt() {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nextLong() {
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}

