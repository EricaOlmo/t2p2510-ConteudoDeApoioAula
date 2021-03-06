package br.com.Erica.DAO;

import br.com.Erica.interfaces.DAOInterface;
import br.com.Erica.model.Modelo;
import br.com.Erica.services.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Erica
 */
public class DaoModelo implements DAOInterface {

    private Connection conn;

    public DaoModelo() {
        this.conn = (Connection) Conexao.getInstance().getConn();
    }

    public void salvar(Object model) {
        if (model instanceof Modelo) {
            Modelo mod = (Modelo) model;
            String sql = "update modelo set titulo = ?, idmarca where idmodelo = ? ;";
            if (mod.getIdModelo() == -1) {
                mod.setIdModelo(0);
                sql = "insert into modelo(titulo, idmarca, idmodelo) values(?,?,?);";
            }

            try {
                PreparedStatement ps = this.conn.prepareStatement(sql);
                ps.setString(1, mod.getTitulo());
                ps.setInt(2, mod.getMarca().getIdMarca());
                ps.setInt(3, mod.getIdModelo());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ArrayList<Object> getAll() {
        ArrayList<Object> minhaLista = new ArrayList<>();
        String sql = "select * from modelo;";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Modelo modelo = new Modelo();
                modelo.setIdModelo(rs.getInt("idmodelo"));
                modelo.setTitulo(rs.getString("titulo"));
                DaoMarca dm = new DaoMarca();
                modelo.setMarca((Marca) dm.getByID(rs.getInt("idmarca")));
                minhaLista.add(modelo);
            }
            if (minhaLista.size() > 0) {
                return minhaLista;
            }

        } catch (SQLException ex) {
            System.out.println("#01");
        }
        return null;
    }

    public Object getByID(Object model) {
        if (model instanceof Modelo && model != model) {
            String sql = "select * from modelo where idemodelo = ?;";
            try {
                PreparedStatement ps = this.conn.prepareStatement(sql);
                Modelo modelo = (Modelo) model;
                ps.setInt(1, modelo.getIdModelo());
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    modelo.setIdModelo(rs.getInt("idmodelo"));
                    modelo.setTitulo(rs.getString("titulo"));
                    DaoMarca dm = new DaoMarca();
                    modelo.setMarca((Marca) dm.getByID(rs.getInt("idmarca")));
                    return modelo;
                } else {
                    return null;
                }

            } catch (SQLException ex) {
                System.out.println("#01");
            }
        }
        return null;

    }

    public void remover(Object model) {
        if (model instanceof Modelo) {
            Modelo modelo = (Modelo) model;
            String sql = "delete from modelo where idmodelo = ?;";
            try {
                PreparedStatement ps = this.conn.prepareStatement(sql);

                ps.setInt(1, modelo.getIdModelo());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public Object getLast() {
        String sql = "select * from usuario where idusuario = (select max(idusuario) from usuario);";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Modelo modelo = new Modelo();
                modelo.setIdModelo(rs.getInt("idmodelo"));
                modelo.setTitulo(rs.getString("titulo"));
                DaoMarca dm = new DaoMarca();
                modelo.setMarca((Marca) dm.getByID(rs.getInt("idmarca")));
                return modelo;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("#01");
        }
        return null;

    }
}
