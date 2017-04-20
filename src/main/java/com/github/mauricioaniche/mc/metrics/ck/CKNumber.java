package com.github.mauricioaniche.mc.metrics.ck;

import com.github.mauricioaniche.mc.MetricsNumber;

public class CKNumber extends MetricsNumber {
	
	private int dit;
	private int noc;
	private int wmc;
	private int cbo;
	private int lcom;
	private int rfc;
	private int nom;
	private int nopm;
	private int nosm;

	private int nof;
	private int nopf;
	private int nosf;

	private int nosi;

	public CKNumber(String file, String className, String type) {
		super(file, className, type);
	}
	
	public int getDit() {
		return dit;
	}

	public void setDit(int dit) {
		this.dit = dit;
	}
	
	public void incNoc() {
		this.noc++;
	}
	
	public int getNoc() {
		return noc;
	}

	public void setWmc(int cc) {
		this.wmc = cc;
	}
	
	public int getWmc() {
		return wmc;
	}


	public int getCbo() {
		return cbo;
	}

	public void setCbo(int cbo) {
		this.cbo = cbo;
	}

	public void setLcom(int lcom) {
		this.lcom = lcom;
	}
	public int getLcom() {
		return lcom;
	}

	public void setRfc(int rfc) {
		this.rfc = rfc;
	}
	
	public int getRfc() {
		return rfc;
	}

	public void setNom(int nom) {
		this.nom = nom;
	}
	public int getNom() {
		return nom;
	}
	

	public int getNopm() {
		return nopm;
	}

	public void setNopm(int nopm) {
		this.nopm = nopm;
	}

	public int getNosm() {
		return nosm;
	}

	public void setNosm(int nosm) {
		this.nosm = nosm;
	}

	public int getNof() {
		return nof;
	}

	public void setNof(int nof) {
		this.nof = nof;
	}

	public int getNopf() {
		return nopf;
	}

	public void setNopf(int nopf) {
		this.nopf = nopf;
	}

	public int getNosf() {
		return nosf;
	}

	public void setNosf(int nosf) {
		this.nosf = nosf;
	}
	
	public int getNosi() {
		return nosi;
	}

	public void setNosi(int nosi) {
		this.nosi = nosi;
	}
	

	@Override
	public String toString() {
		return "CKNumber [className=" + className + ", type=" + type + ", dit=" + dit + ", noc="
				+ noc + ", wmc=" + wmc + ", cbo=" + cbo + ", lcom=" + lcom + ", rfc=" + rfc + ", nom=" + nom + ", nopm="
				+ nopm + ", nosm=" + nosm + ", nof=" + nof + ", nopf=" + nopf + ", nosf=" + nosf + ", nosi=" + nosi
				+ ", loc=" + loc + ", specific=" + specific + ", error=" + error + "]";
	}


}
