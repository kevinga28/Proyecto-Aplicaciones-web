
package Proyecto.Proyecto.service.impl;

import Proyecto.Proyecto.db.IUsuarioRepository;
import Proyecto.Proyecto.entities.Usuario;
import Proyecto.Proyecto.service.IUsuarioService;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService extends BaseService<Usuario, Integer> implements IUsuarioService {
    public UsuarioService(IUsuarioRepository UsuarioRepository) {
        super(UsuarioRepository);
    }

}
