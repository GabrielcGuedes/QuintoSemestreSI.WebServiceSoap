/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import Classes.Produto;
import Util.ProdutoDao;
import java.sql.SQLException;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author alunocmc
 */
@WebService (serviceName = "produtows")
public class ProdutoWS {
    public List<Produto> listarTodos() throws SQLException, ClassNotFoundException{
        ProdutoDao dao = new ProdutoDao();
        return dao.consultarTodos();
    }
    public Produto consultarProduto(Produto produto) throws ClassNotFoundException, SQLException{
       ProdutoDao dao = new ProdutoDao();
        return dao.consultarPorId(produto);
    }
    public Produto cadastrar (Produto produto) throws ClassNotFoundException, SQLException{
        ProdutoDao dao = new ProdutoDao();
        dao.cadastrar(produto);
        return produto;
    }
    public Produto excluir (Produto produto) throws ClassNotFoundException, SQLException {
       ProdutoDao dao = new ProdutoDao();
       dao.excluir(produto);
       return produto;
    }
    public Produto editar (Produto produto) throws ClassNotFoundException, SQLException{
        ProdutoDao dao = new ProdutoDao();
        dao.editar(produto);
        return produto;
    }
}
