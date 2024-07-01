package com.asong.study_total.create;


import lombok.Data;
import org.springframework.util.StringUtils;

import javax.swing.text.html.Option;
import java.util.Optional;

public class ResourcePoolConfig {
    private String name;

    private int maxTotal;

    private int maxIdle;

    private int minIdle;


    private ResourcePoolConfig(Builder builder){

        this.name = builder.name;
        this.maxIdle = builder.maxIdle;
        this.maxTotal = builder.maxTotal;
        this.minIdle = builder.minIdle;
    }

    @Data()
    public static class Builder{
        public String name;

        public int maxTotal;

        public int maxIdle;

        public int minIdle;

        public Builder (String name,int maxTotal){
            this.name = name;
            this.maxTotal = maxTotal;
        }

        public Builder setMaxTotal(int maxTotal){
            if(maxTotal <= 0){
                throw new IllegalArgumentException("maxTotal must be > 0");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMinIdle(int minIdle){
            if(minIdle <= 0){
                throw new IllegalArgumentException("minIdle must be > 0");
            }
            this.minIdle = minIdle;
            return this;
        }

        public ResourcePoolConfig build(){
            if(!StringUtils.hasText(this.name)||this.minIdle==0||this.maxTotal==0||this.maxIdle==0){
                throw new IllegalArgumentException("name,minIdle,maxTotal,maxIdle must be not null");
            }
            return new ResourcePoolConfig(this);
        }
    }

    public static void main(String[] args) {
       // ResourcePoolConfig build = new Builder().setMaxTotal(10).setMinIdle(5).build();
        Builder builder = new Builder("bai",3);
        Builder builder1 = new Builder("bai",1);
        Builder builder2 = new Builder("bai",2);

        Optional<Builder> builderOptional= Optional.ofNullable(builder);
        builder = builderOptional.orElse(builder1);
       // builder = builderOptional.orElseGet(()->builder2);

        System.out.println(builder.toString());

    }

}
