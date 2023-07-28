
package Proyecto.Proyecto.service.impl;
import Proyecto.Proyecto.db.IClienteRepository;
import Proyecto.Proyecto.entities.Cliente;
import Proyecto.Proyecto.service.IClienteService;
import org.springframework.stereotype.Service;


@Service
public class ClienteService extends BaseService<Cliente, Integer> implements IClienteService {
    public ClienteService(IClienteRepository ClienteRepository) {
        super(ClienteRepository);
    }

}
