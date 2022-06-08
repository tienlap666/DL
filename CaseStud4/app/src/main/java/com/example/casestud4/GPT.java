package com.example.casestud4;

public class GPT {
    private int A;
    private int B;
    private int C;

    GPT(int a, int b, int c){
        this.A=a;
        this.B=b;
        this.C=c;
    }
    public String NPT(){
        String st = "";
        float denta = B*B - 4*A*C;
        if (denta<0)
            st = "Phuong Trinh Vo Nghiem";
        if (denta == 0)
            st = "Phuong Trinh Co Nghiem Kep x = "+(-B*1.0/(2*A));
        else {
            st = "Phuong Trinh Co 2 Nghiem";
            st += "\n x1 = "+(-B + Math.sqrt(denta))/(2*A);
            st += "\n x1 = "+(-B - Math.sqrt(denta))/(2*A);
        }
        return st;
    }

}
