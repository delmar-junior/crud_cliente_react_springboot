import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";

import api from "../../services/api";
import { login } from "../../services/auth";

import { Form, Container } from "./styles";

class SignIn extends Component {
  state = {
    usuario: "",
    senha: "",
    error: ""
  };

  handleSignIn = async e => {
    e.preventDefault();
    const { usuario, senha } = this.state;
    if (!usuario || !senha) {
      this.setState({ error: "Preencha e-mail e senha para continuar!" });
    } else {
      try {
        const response = await api.post("/auth/login", { usuario, senha });
        login(response.data.token);
        this.props.history.push("/app");
      } catch (err) {
        this.setState({
          error:
            "Houve um problema com o login, verifique suas credenciais. T.T"
        });
      }
    }
  };

  render() {
    return (
      <Container>
        <Form onSubmit={this.handleSignIn}>
          {this.state.error && <p>{this.state.error}</p>}
            <div className="form-group">
                <label>Usuario:  </label>
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
                    value="Entrar" 
                    className="btn btn-primary"/>
            </div>
          <hr />
          <Link to="/signup">Criar conta grátis</Link>
        </Form>
      </Container>
    );
  }
}

export default withRouter(SignIn);
