import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import api from "../../services/api";

class TableRow extends Component {
    constructor(props) {
        super(props);
        this.delete = this.delete.bind(this);
    }
    async delete() {
        if (window.confirm("Deseja realmente excluir esse registro?")) {
            try {
                await api.delete("/cliente/"+this.props.obj.id)
                // this.props.history.push("/");
                window.location.reload();
                console.log('Deletado')
            } catch (err) {
                console.log(err)
            }
        }
    }
    render() {
        return (
            <tr>
                <td>
                    {this.props.obj.nome}
                </td>
                <td>
                    {this.props.obj.cpf}
                </td>
                <td>
                    {"CEP: " +
                     this.props.obj.cep + ", " + 
                     this.props.obj.logradouro + ", " + 
                    //  this.props.odj.bairro + ", " + 
                     this.props.obj.cidade + ", " + 
                     this.props.obj.uf}
                </td>
                <td>
                    <Link to={"/edit/"+this.props.obj.id} className="btn btn-primary">Edit</Link>
                </td>
                <td>
                    <button onClick={this.delete} className="btn btn-danger">Delete</button>
                </td>
            </tr>
        );
  }
}

export default TableRow;