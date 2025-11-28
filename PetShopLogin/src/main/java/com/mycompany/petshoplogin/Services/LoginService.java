package com.mycompany.petshoplogin.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginService {
    public boolean autenticar(String usuario, String senha) {
        if(usuario == null || usuario.isEmpty() || senha == null || senha.isEmpty()) {
            return false;
        }
        
        try {
            File arquivo = new File("usuarios.txt");
            
            // Se o arquivo não existe, cria com um usuário padrão
            if (!arquivo.exists()) {
                System.out.println("Arquivo usuarios.txt não encontrado. Criando...");
                return criarArquivoPadrao(usuario, senha);
            }
            
            // Lê o arquivo de usuários
            BufferedReader reader = new BufferedReader(new FileReader(arquivo));
            String linha;
            
            while ((linha = reader.readLine()) != null) {
                linha = linha.trim();
                // Ignora linhas vazias ou comentários
                if(linha.isEmpty() || linha.startsWith("#")) {
                    continue;
                }
                
                String[] partes = linha.split(";");
                if (partes.length == 2) {
                    String usuarioArquivo = partes[0].trim();
                    String senhaArquivo = partes[1].trim();
                    
                    if (usuario.equals(usuarioArquivo) && senha.equals(senhaArquivo)) {
                        reader.close();
                        return true;
                    }
                }
            }
            reader.close();
            
        } catch (IOException e) {
            System.err.println("Erro ao acessar arquivo: " + e.getMessage());
            // Fallback para teste
            return "admin".equals(usuario) && "1234".equals(senha);
        }
        
        return false;
    }
    
    private boolean criarArquivoPadrao(String usuario, String senha) {
        // Verifica se é o usuário padrão
        if("admin".equals(usuario) && "1234".equals(senha)) {
            System.out.println("Usando credenciais padrão (admin/1234)");
            return true;
        }
        return false;
    }
}