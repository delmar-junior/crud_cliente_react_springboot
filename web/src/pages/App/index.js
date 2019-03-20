import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";

import api from "../../services/api";
import TableRow from './TableRow';

import { Subcontainer, Container } from "./styles";

class App extends Component {
  state = {
    error: "",
    clientes: []
  };

  async componentDidMount(){

    try {
        const response = await api.get("/cliente");
        this.setState({ clientes: response.data });

    } catch (err) {
        this.setState({
            error:
            "Houve um problema ao listar os clientes."
        });
    }
  }
  tabRow(){
    return this.state.clientes.map((object, i) => {
        return <TableRow obj={object} key={i} />;
    });
  }

  render() {
    return (
        <Container>
            <Subcontainer>
                <h3 align="center">Lista de Clientes</h3>
                <table className="table table-striped" style={{ marginTop: 20 }}>
                    <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Endereço</th>
                        <th colSpan="2">
                            Action <Link to={"/edit/novo"} className="btn btn-primary">Novo</Link>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    { this.tabRow() }
                    </tbody>
                </table>
            </Subcontainer>
        </Container>
    );
  }
}

export default withRouter(App);
