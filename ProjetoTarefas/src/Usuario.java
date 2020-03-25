import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Usuario {
    private Long usuarioId;
    private String nome;
    private String email;
    private String telefone;
    private Date dataNascimento;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setId(Long id) {
        this.usuarioId = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void MostraTarefa(Long tarefaId1){
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            stmt = connection.prepareStatement("select * from tarefa");
            ResultSet rs = stmt.executeQuery();

            stmt2 = connection.prepareStatement("select * from item");
            ResultSet rs2 = stmt2.executeQuery();

            while (rs.next()) {
                Long tarefaId = rs.getLong("tarefaId");
                if (tarefaId == tarefaId1 ) {
                    String titulo = rs.getString("titulo");
                    String descricao = rs.getString("descricao");

                    System.out.println("\n" + titulo + " : " + descricao);
                }
                while(rs2.next()){
                    Long tarefaId2 = rs2.getLong("tarefaId");
                    if(tarefaId2 == tarefaId1){
                        String nome = rs2.getString("nome");
                        boolean pronto = rs2.getBoolean("pronto");

                        System.out.println(nome + " : " + pronto);
                    }
                }
            }

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void MostraTarefas(){
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            stmt = connection.prepareStatement("select * from tarefa");
            ResultSet rs = stmt.executeQuery();

            stmt2 = connection.prepareStatement("select * from item");
            ResultSet rs2 = stmt2.executeQuery();

            System.out.println("Tarefas do usuario " + usuarioId);
            while (rs.next()) {
                Long usuarioId1 = rs.getLong("UsuarioId");
                if (usuarioId1 == usuarioId ) {
                    String titulo = rs.getString("titulo");
                    String descricao = rs.getString("descricao");
                    Long tarefaId1 = rs.getLong("tarefaId");
                    System.out.println("\n" + titulo + " : " + descricao);

                        while (rs2.next()){
                            Long tarefaId2 = rs2.getLong("tarefaId");
                            if (tarefaId1 == tarefaId2){
                            String nome = rs2.getString("nome");
                            boolean pronto = rs2.getBoolean("pronto");

                            System.out.println(nome + " : " + pronto);
                        }
                    }
                }
            }

            stmt.close();
            connection.close();

            stmt2.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Usuario teste1 = new Usuario();
        teste1.setId(3L);
        teste1.MostraTarefas();
//        teste1.MostraTarefa(2L);
    }
}
