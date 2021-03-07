package TPO;

public class TipoYNroDoc implements Comparable{
	private String tipoDoc;
	private String nroDoc;
	
	public TipoYNroDoc(String tipoDNI, String nroDNI) {
		this.tipoDoc = tipoDNI;
		this.nroDoc = nroDNI;
	}
	
	public int compareTo(Object otroCliente) {
		TipoYNroDoc otroDoc= (TipoYNroDoc)otroCliente;
		int comp= this.tipoDoc.compareTo(otroDoc.tipoDoc);
		if(comp==0) {
			comp=this.nroDoc.compareTo(otroDoc.nroDoc);
		}
		return comp;
	}
	
	public String toString() {
		return this.tipoDoc+""+this.nroDoc;
	}
	
	public String toStringConComa() {
		return this.tipoDoc+","+this.nroDoc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nroDoc == null) ? 0 : nroDoc.hashCode());
		result = prime * result + ((tipoDoc == null) ? 0 : tipoDoc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoYNroDoc other = (TipoYNroDoc) obj;
		if (nroDoc == null) {
			if (other.nroDoc != null)
				return false;
		} else if (!nroDoc.equals(other.nroDoc))
			return false;
		if (tipoDoc == null) {
			if (other.tipoDoc != null)
				return false;
		} else if (!tipoDoc.equals(other.tipoDoc))
			return false;
		return true;
	}

}