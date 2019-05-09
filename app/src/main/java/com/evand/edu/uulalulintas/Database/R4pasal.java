package com.evand.edu.uulalulintas.Database;

/**
 * Created by ACER on 05/01/2015.
 */
public class R4pasal {
    private long no;
    private String pelanggaran;
    private String pasal;
    private String sanksi;

    public R4pasal()
    {

    }

    public void setNo(long no) {
        this.no = no;
    }

    public String getPelanggaran() {
        return pelanggaran;
    }

    public void setPelanggaran(String pelanggaran) {
        this.pelanggaran = pelanggaran;
    }

    public String getPasal() {
        return pasal;
    }

    public void setPasal(String pasal) {
        this.pasal = pasal;
    }

    public String getSanksi() {
        return sanksi;
    }

    public void setSanksi(String sanksi) {
        this.sanksi = sanksi;
    }

}
