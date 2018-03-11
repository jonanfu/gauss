package gauss;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CEcuaciones 
{
    private int Ecuacion[][];
    private ArrayList<String> Reglones=new <String>ArrayList();
    private ArrayList <String> StringMatrices=new ArrayList<String>();
    private ArrayList <Double> Respuestas=new ArrayList<Double>();
    
    public CEcuaciones (int dim)
    {
        Ecuacion=new int[dim][dim+1];
    }

    public void setEcuacion(int[][] Ecuacion)
    {
        this.Ecuacion = Ecuacion;
    }
     
    public void ObtenerReglones()
    {
        int cont=1;
        for (int i = 0; i<Ecuacion[0].length; i++)
        {
            for (int j =Ecuacion.length-1; j >=0; j--) 
            {
                if (j!=i && i<Ecuacion[0].length-1)
                {
                    Reglones.add(""+j+i);
                }
            }
        }
    }
    public void OperacionBásica()
    {
        ObtenerReglones();
        StringMatrices();
        for (int k =0; k<Reglones.size(); k++) 
        {
            int fil=Integer.parseInt(String.valueOf(Reglones.get(k).charAt(0)));
            int col=Integer.parseInt(String.valueOf(Reglones.get(k).charAt(1)));

            if (Ecuacion[fil][col]<0 && Ecuacion[col][col]<0)
            {   
                int numa=Ecuacion[fil][col];
                int numb=Ecuacion[col][col];
                for (int i = 0; i < Ecuacion[0].length; i++) 
                {
                    Ecuacion[fil][i]=(numb*Ecuacion[fil][i])-(numa*Ecuacion[col][i]);                    
                }               
            }else if (Ecuacion[fil][col]>0 && Ecuacion[col][col]>0)
            {
                int numa=Ecuacion[fil][col];
                int numb=Ecuacion[col][col];
                for (int i = 0; i < Ecuacion[0].length; i++) 
                {
                    Ecuacion[fil][i]=(numb*Ecuacion[fil][i])-(numa*Ecuacion[col][i]);                    
                } 
            }else 
            {
                int numa=Ecuacion[fil][col];
                int numb=Ecuacion[col][col];
                for (int i = 0; i < Ecuacion[0].length; i++) 
                {
                    Ecuacion[fil][i]=(numb*Ecuacion[fil][i])-(numa*Ecuacion[col][i]);                    
                } 
            }
            StringMatrices();
        }
        
    }
    public void StringMatrices()
    {
        String q="";
        for (int i = 0; i < Ecuacion.length; i++) 
        {
            for (int j = 0; j < Ecuacion[i].length; j++) 
            {
                q=q+Ecuacion[i][j]+"  ";
            }
            q=q+"\n";
        }

        StringMatrices.add(q);
    }
    public ArrayList<String> ResueltoCaracteres()
    {
        return StringMatrices;
    }
    public void Respuestas()
    {
        for (int i = 0; i < Ecuacion.length; i++) 
        {    
            double e=((double)Ecuacion[i][Ecuacion[0].length-1])/((double)Ecuacion[i][i]);
            System.err.println(e);
            Respuestas.add(e);
        }
    }
    public ArrayList<Double> getRespuestas()
    {
        return Respuestas;
    }
}
