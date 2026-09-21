import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {
    
    public Connection connectDB(){
        Connection conn = null;
        
        try {
           
            String url = "jdbc:mysql://localhost:3306/uc11atividade?useSSL=false&allowPublicKeyRetrieval=true";
            String usuario = "root";
            String senha = "ero3803"; 
            
            conn = DriverManager.getConnection(url, usuario, senha);
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO: " + erro.getMessage());
        }
        return conn;
    }

    // MÉTODO DE TESTE
    public static void main(String[] args) {
        conectaDAO dao = new conectaDAO();
        Connection conn = dao.connectDB();
        
        if (conn != null) {
            JOptionPane.showMessageDialog(null, "Conexão com o banco uc11atividade realizada com SUCESSO!");
            try {
                conn.close();
            } catch (SQLException e) {
                // Ignore
            }
        }
    }
}