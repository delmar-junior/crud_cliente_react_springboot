import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";

import api from "../../services/api";

import { Form, Container } from "./styles";

class SignUp extends Component {
  state = {
    usuario: "",
    nome: "",
    senha: "",
    error: ""
  };

  handleSignUp = async e => {
    e.preventDefault();
    const { usuario, nome, senha } = this.state;
    if (!usuario || !nome || !senha) {
      this.setState({ error: "Preencha todos os dados para se cadastrar" });
    } else {
      try {
        await api.post("/users", { usuario, nome, senha });
        this.props.history.push("/");
      } catch (err) {
        console.log(err);
        this.setState({ error: "Ocorreu um erro ao registrar sua conta. T.T" });
      }
    }
  };

  render() {
    return (
      <Container>
        <Form onSubmit={this.handleSignUp}>
          {this.state.error && <p>{this.state.error}</p>}
          <div className="form-group">
            <label>Nome:  </label>
            <input 
                type="text" 
                className="form-control" 
                onChange={e => this.setState({ nome: e.target.value })}
                />
          </div>
          <div className="form-group">
            <label>Usuário:  </label>
            <input 
                type="text" 
                className="form-control" 
                onChange={e => this.setState({ usuario: e.target.value })}
                />
          </div>
          <div className="form-group">
            <label>Senha:  </label>
            <input 
                type="text" 
                className="form-control" 
                onChange={e => this.setState({ senha: e.target.value })}
                />
          </div>
          <div className="form-group">
            <input type="submit" 
                value="Cadastrar grátis" 
                className="btn btn-primary"/>
          </div>
          <hr />
          <Link to="/">Fazer login</Link>
        </Form>
      </Container>
    );
  }
}

export default withRouter(SignUp);
