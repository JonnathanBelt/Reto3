package Reto3G36.Reto3.service;

import Reto3G36.Reto3.model.Categoria;
import Reto3G36.Reto3.repository.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosCategoria {
    @Autowired
    private RepositorioCategoria metodosCrud;

    public List<Categoria> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Categoria>getCategoria (int CategoriaID){
        return metodosCrud.getCategoria(CategoriaID);
    }

    public Categoria save (Categoria categoria){
        if (categoria.getId()==null){
            return metodosCrud.save(categoria);
        }else {
            Optional<Categoria>categoria1 = metodosCrud.getCategoria(categoria.getId());
            if (categoria1.isEmpty()){
                return metodosCrud.save(categoria);
            }else{
                return categoria;
            }
        }
    }

    public Categoria update (Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria> g=metodosCrud.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }
    public boolean deletecategoria (int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }


}
