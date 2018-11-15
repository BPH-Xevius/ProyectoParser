package libros;

import java.io.Serializable;

public class Libros implements Serializable {
	
	private int paginas=0;
	private String titulo=null, autor=null, editor=null;
	
	public Libros (String nombre, int edad) 
	{
		
	}
	
	public Libros (String tit, String aut, String edit, int pags) 
	{
		titulo=tit;
		autor=aut;
		editor=edit;
		paginas=pags;	
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	public void mostrar()
	{
		System.out.println("Titulo: "+titulo+" Autor: "+autor+" Editor: "+editor+" Paginas: "+paginas);
	}
}
