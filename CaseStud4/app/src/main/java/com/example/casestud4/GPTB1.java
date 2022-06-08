package com.example.casestud4;

public class GPTB1 {
    private int a;
    private int b;

    GPTB1(int a, int b ){
        this.a = a;
        this.b = b;
    }
    public String NPT(){
        float kq=(float) a/b;
        String kqc = "nghiem cua pt la"+kq;
        return  kqc;
    }
}
