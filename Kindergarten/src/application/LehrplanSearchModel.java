package application;

public class LehrplanSearchModel {
	String wochen;
	String september;
	String oktober;
	String november;
	String dezember;
	String januar;
	String februar;
	String marz;
	String april;
	String mai;
	String juni;
	
	public String getWochen() {
		return wochen;
	}

	public void setWochen(String wochen) {
		this.wochen = wochen;
	}
	
	public String getSeptember() {
		return september;
	}

	public void setSeptember(String september) {
		this.september = september;
	}

	public String getOktober() {
		return oktober;
	}

	public void setOktober(String october) {
		this.oktober = october;
	}

	public String getNovember() {
		return november;
	}

	public void setNovember(String november) {
		this.november = november;
	}

	public String getDezember() {
		return dezember;
	}

	public void setDezember(String dezember) {
		this.dezember = dezember;
	}

	public String getJanuar() {
		return januar;
	}

	public void setJanuar(String januar) {
		this.januar = januar;
	}

	public String getFebruar() {
		return februar;
	}

	public void setFebruar(String februar) {
		this.februar = februar;
	}

	public String getMarz() {
		return marz;
	}

	public void setMarz(String marz) {
		this.marz = marz;
	}

	public String getApril() {
		return april;
	}

	public void setApril(String april) {
		this.april = april;
	}

	public String getMai() {
		return mai;
	}

	public void setMai(String mai) {
		this.mai = mai;
	}

	public String getJuni() {
		return juni;
	}

	public void setJuni(String juni) {
		this.juni = juni;
	}

	public LehrplanSearchModel(String wochen,String september,String oktober,String november,String dezember,String januar,String februar,String marz,String april,String mai,String juni){
		this.wochen=wochen;
		this.september=september;
		this.oktober=oktober;
		this.november=november;
		this.dezember=dezember;
		this.januar=januar;
		this.februar=februar;
		this.marz=marz;
		this.april=april;
		this.mai=mai;
		this.juni=juni;
	}
}
