/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: almaviva
 * License Type: Purchased
 */
package it.finsiel.sbn.polo.orm.viste;

import it.finsiel.sbn.polo.orm.KeyParameter;
/**
 * ORM-Persistable Class
 */
public class Vf_cartografia_luo extends V_cartografia {

	private static final long serialVersionUID = -8901322975721172959L;

	public boolean equals(Object aObj) {
		if (aObj == null)
			return false;
		if (!(aObj instanceof Vf_cartografia_luo))
			return false;
		Vf_cartografia_luo vf_cartografia_luo = (Vf_cartografia_luo)aObj;
		if (getBID() != null && !getBID().equals(vf_cartografia_luo.getBID()))
			return false;
		if (getLID() != null && !getLID().equals(vf_cartografia_luo.getLID()))
			return false;
		return true;
	}

	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + getBID().hashCode();
		hashcode = hashcode + getLID().hashCode();
		return hashcode;
	}

	private String CD_LIVELLO_C;

	private String TP_PUBB_GOV;

	private String CD_COLORE;

	private String CD_MERIDIANO;

	private String CD_SUPPORTO_FISICO;

	private String CD_TECNICA;

	private String CD_FORMA_RIPR;

	private String CD_FORMA_PUBB;

	private String CD_ALTITUDINE;

	private String CD_TIPOSCALA;

	private String TP_SCALA;

	private String SCALA_ORIZ;

	private String SCALA_VERT;

	private String LONGITUDINE_OVEST;

	private String LONGITUDINE_EST;

	private String LATITUDINE_NORD;

	private String LATITUDINE_SUD;

	private String TP_IMMAGINE;

	private String CD_FORMA_CART;

	private String CD_PIATTAFORMA;

	private String CD_CATEG_SATELLITE;

	private String LID;

	private String KY_NORM_LUOGO;

	public void setCD_LIVELLO_C(String value) {
		this.CD_LIVELLO_C = value;
    this.settaParametro(KeyParameter.XXXcd_livello_c,value);
	}

	public String getCD_LIVELLO_C() {
		return CD_LIVELLO_C;
	}

	public void setTP_PUBB_GOV(String value) {
		this.TP_PUBB_GOV = value;
    this.settaParametro(KeyParameter.XXXtp_pubb_gov,value);
	}

	public String getTP_PUBB_GOV() {
		return TP_PUBB_GOV;
	}

	public void setCD_COLORE(String value) {
		this.CD_COLORE = value;
    this.settaParametro(KeyParameter.XXXcd_colore,value);
	}

	public String getCD_COLORE() {
		return CD_COLORE;
	}

	public void setCD_MERIDIANO(String value) {
		this.CD_MERIDIANO = value;
    this.settaParametro(KeyParameter.XXXcd_meridiano,value);
	}

	public String getCD_MERIDIANO() {
		return CD_MERIDIANO;
	}

	public void setCD_SUPPORTO_FISICO(String value) {
		this.CD_SUPPORTO_FISICO = value;
    this.settaParametro(KeyParameter.XXXcd_supporto_fisico,value);
	}

	public String getCD_SUPPORTO_FISICO() {
		return CD_SUPPORTO_FISICO;
	}

	public void setCD_TECNICA(String value) {
		this.CD_TECNICA = value;
    this.settaParametro(KeyParameter.XXXcd_tecnica,value);
	}

	public String getCD_TECNICA() {
		return CD_TECNICA;
	}

	public void setCD_FORMA_RIPR(String value) {
		this.CD_FORMA_RIPR = value;
    this.settaParametro(KeyParameter.XXXcd_forma_ripr,value);
	}

	public String getCD_FORMA_RIPR() {
		return CD_FORMA_RIPR;
	}

	public void setCD_FORMA_PUBB(String value) {
		this.CD_FORMA_PUBB = value;
    this.settaParametro(KeyParameter.XXXcd_forma_pubb,value);
	}

	public String getCD_FORMA_PUBB() {
		return CD_FORMA_PUBB;
	}

	public void setCD_ALTITUDINE(String value) {
		this.CD_ALTITUDINE = value;
    this.settaParametro(KeyParameter.XXXcd_altitudine,value);
	}

	public String getCD_ALTITUDINE() {
		return CD_ALTITUDINE;
	}

	public void setCD_TIPOSCALA(String value) {
		this.CD_TIPOSCALA = value;
    this.settaParametro(KeyParameter.XXXcd_tiposcala,value);
	}

	public String getCD_TIPOSCALA() {
		return CD_TIPOSCALA;
	}

	public void setTP_SCALA(String value) {
		this.TP_SCALA = value;
    this.settaParametro(KeyParameter.XXXtp_scala,value);
	}

	public String getTP_SCALA() {
		return TP_SCALA;
	}

	public void setSCALA_ORIZ(String value) {
		this.SCALA_ORIZ = value;
    this.settaParametro(KeyParameter.XXXscala_oriz,value);
	}

	public String getSCALA_ORIZ() {
		return SCALA_ORIZ;
	}

	public void setSCALA_VERT(String value) {
		this.SCALA_VERT = value;
    this.settaParametro(KeyParameter.XXXscala_vert,value);
	}

	public String getSCALA_VERT() {
		return SCALA_VERT;
	}

	public void setLONGITUDINE_OVEST(String value) {
		this.LONGITUDINE_OVEST = value;
    this.settaParametro(KeyParameter.XXXlongitudine_ovest,value);
	}

	public String getLONGITUDINE_OVEST() {
		return LONGITUDINE_OVEST;
	}

	public void setLONGITUDINE_EST(String value) {
		this.LONGITUDINE_EST = value;
    this.settaParametro(KeyParameter.XXXlongitudine_est,value);
	}

	public String getLONGITUDINE_EST() {
		return LONGITUDINE_EST;
	}

	public void setLATITUDINE_NORD(String value) {
		this.LATITUDINE_NORD = value;
    this.settaParametro(KeyParameter.XXXlatitudine_nord,value);
	}

	public String getLATITUDINE_NORD() {
		return LATITUDINE_NORD;
	}

	public void setLATITUDINE_SUD(String value) {
		this.LATITUDINE_SUD = value;
    this.settaParametro(KeyParameter.XXXlatitudine_sud,value);
	}

	public String getLATITUDINE_SUD() {
		return LATITUDINE_SUD;
	}

	public void setTP_IMMAGINE(String value) {
		this.TP_IMMAGINE = value;
    this.settaParametro(KeyParameter.XXXtp_immagine,value);
	}

	public String getTP_IMMAGINE() {
		return TP_IMMAGINE;
	}

	public void setCD_FORMA_CART(String value) {
		this.CD_FORMA_CART = value;
    this.settaParametro(KeyParameter.XXXcd_forma_cart,value);
	}

	public String getCD_FORMA_CART() {
		return CD_FORMA_CART;
	}

	public void setCD_PIATTAFORMA(String value) {
		this.CD_PIATTAFORMA = value;
    this.settaParametro(KeyParameter.XXXcd_piattaforma,value);
	}

	public String getCD_PIATTAFORMA() {
		return CD_PIATTAFORMA;
	}

	public void setCD_CATEG_SATELLITE(String value) {
		this.CD_CATEG_SATELLITE = value;
    this.settaParametro(KeyParameter.XXXcd_categ_satellite,value);
	}

	public String getCD_CATEG_SATELLITE() {
		return CD_CATEG_SATELLITE;
	}

	public void setLID(String value) {
		this.LID = value;
    this.settaParametro(KeyParameter.XXXlid,value);
	}

	public String getLID() {
		return LID;
	}

	public void setKY_NORM_LUOGO(String value) {
		this.KY_NORM_LUOGO = value;
    this.settaParametro(KeyParameter.XXXky_norm_luogo,value);
	}


 public String getKY_NORM_LUOGO() {
		return KY_NORM_LUOGO;
	}

	public String toString() {
		return String.valueOf(getBID() + " " + getLID());
	}

}
