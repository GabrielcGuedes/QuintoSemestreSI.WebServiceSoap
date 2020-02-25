/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Classes.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alunocmc
 */
public class ProdutoDao {
    public void cadastrar(Produto produto) throws ClassNotFoundException, SQLException{
     Connection con = FabricaConexao.getConexao();
     
      PreparedStatement comando = con.prepareStatement("insert into produto (id,descricao,preco,quantidade) values (?,?,?,?)");
      comando.setInt(1, produto.getId());
      comando.setString(2,produto.getDescricao());
      comando.setDouble(3, produto.getPreco());
      comando.setInt(4, produto.getQuantidade());
      comando.execute();
      
      
      con.close();  
    }
    
    public List<Produto> consultarTodos() throws SQLException, ClassNotFoundException{
        Connection con = FabricaConexao.getConexao();
       
       PreparedStatement comando = con.prepareStatement("select*from produto");
       ResultSet resultado = comando.executeQuery();
       
       List<Produto> todosProdutos = new ArrayList<Produto>();
       while (resultado.next()){
           Produto prod = new Produto();
           prod.setId(resultado.getInt("id"));
           prod.setDescricao(resultado.getString("descricao"));
           prod.setPreco(resultado.getDouble("preco"));
           prod.setQuantidade(resultado.getInt("quantidade"));
           todosProdutos.add(prod);
       }
       con.close();
       return todosProdutos; 
    }
    public void editar(Produto produto) throws ClassNotFoundException, SQLException{
        Connection con = FabricaConexao.getConexao();
        
        PreparedStatement comando = con.prepareStatement("update produto set descricao = ?, preco = ?, quantidade = ? where id=?");
        comando.setInt(4, produto.getId());
        comando.setString(1,produto.getDescricao());
        comando.setDouble(2, produto.getPreco());
        comando.setInt(3, produto.getQuantidade());
        comando.execute();
      
      
      con.close(); 
    }
    public void excluir(Produto produto) throws ClassNotFoundException, SQLException{
        Connection con = FabricaConexao.getConexao();
        
        PreparedStatement comando = con.prepareStatement("delete from produto where id=?");
        comando.setInt(1, produto.getId());
        comando.execute();
        
        con.close();  
    }
    public Produto consultarPorId(Produto produto) throws ClassNotFoundException, SQLException{
        Connection con = FabricaConexao.getConexao();
       
       PreparedStatement comando = con.prepareStatement("select*from produto where id=?");
       comando.setInt(1, produto.getId());
       ResultSet resultado = comando.executeQuery();
       Produto produtoId = null;
        if(resultado.next()){
           Produto prod = new Produto();
           prod.setId(resultado.getInt("id"));
           prod.setDescricao(resultado.getString("descricao"));
           prod.setPreco(resultado.getDouble("preco"));
           prod.setQuantidade(resultado.getInt("quantidade"));
           produtoId = prod;
           }
           con.close(); 
          return produtoId;
       
        
    }

    
}
