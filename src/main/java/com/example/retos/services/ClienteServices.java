package com.example.retos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retos.entities.Cliente;
import com.example.retos.repositories.ClienteRepository;

@Service
public class ClienteServices {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServices(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    // CRUD

    // GET
    public List<Cliente> getListCliente() {
        return this.clienteRepository.findAll();
    }

    // GET ID
    public Cliente getCliente(int id) {
        if(!this.clienteRepository.findById(id).isEmpty()){
            return this.clienteRepository.findById(id).get();
        }else{
            return null;
        }
       
    }

    // POST
    public Cliente crearCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    // DELETE
    public boolean eliminarCliente(int id) {
          if(!this.clienteRepository.findById(id).isEmpty()){
            this.clienteRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
      
    }
    //PUT ACTUALIZAR
    public boolean actualizarCliente(int id, Cliente clienteSet){
        if(!this.clienteRepository.findById(id).isEmpty()){
            Cliente cliente = clienteRepository.findById(id).get();
            if(clienteSet.getName()!= null){
                cliente.setName(clienteSet.getName());
            }
            if(clienteSet.getEmail()!=null){
                cliente.setEmail(clienteSet.getEmail());
            }
            if(clienteSet.getAge()!=null){
                cliente.setAge(clienteSet.getAge());
            }
            this.clienteRepository.save(cliente);
            return true;

        }else{
            return false;
        }

    }
}