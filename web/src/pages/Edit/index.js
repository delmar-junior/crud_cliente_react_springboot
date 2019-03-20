import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";
import axios from 'axios';

import api from "../../services/api";

import { Form, Container } from "./styles";

class Edit extends Component {

    constructor() {
        super();
        // this.addTelefone = this.addTelefone.bind(this);
        // this.removeTelefone = this.removeTelefone.bind(this);
        this.onChangeCEP = this.onChangeCEP.bind(this);
        this.state = {
            id: null,
            nome: "",
            cpf: "",
            cep: "",
            logradouro: "",
            complemento: "",
            bairro: "",
            numero: "",
            cidade: "",
            uf: "",
            telefone: "",
            listaTelefone: [{ numero: "", tipo: "" }],
            listaEmail: [{ email: "" }]
        };
    }


    async componentDidMount(){
        let id = this.props.match.params.id;
        if (id) {
            try {
                const response = await api.get("/cliente/"+id);
                console.log(response.data)
                var { nome, cpf, cep, logradouro, complemento, bairro, numero, cidade, uf, telefone, listaTelefone, listaEmail } = response.data;
                if (listaTelefone.length === 0) {
                    listaTelefone.push({ numero: "", tipo: "" });
                }
                if (listaEmail.length === 0) {
                    listaEmail.push({ email: "" });
                }
                this.setState({ id, nome, cpf, cep, logradouro, complemento, bairro, numero, cidade, uf, telefone, listaTelefone, listaEmail });
                console.log(this.state)
                
            } catch (err) {
                console.log(err);
                this.setState({ error: "Ocorreu um erro ao salvar o cliente" });
            }
            this.setState({id})
        }

        if (!this.state.listaTelefone) {
            this.addTelefone();
        }
    }

    handleEdit = async e => {
        e.preventDefault();
        const { id, nome, cpf, cep, logradouro, complemento, bairro, numero, cidade, uf, listaTelefone, listaEmail } = this.state;
        if (!nome || !cpf || !cep || !logradouro || !bairro || !numero || !cidade || !uf) {
            this.setState({ error: "Preencha todos os dados para se cadastrar" });
        } else {
            try {
                if (id) {
                    await api.put("/cliente/"+id, { nome, cpf, cep, logradouro, complemento, bairro, numero, cidade, uf, listaTelefone, listaEmail });
                } else {
                    await api.post("/cliente", { nome, cpf, cep, logradouro, complemento, bairro, numero, cidade, uf, listaTelefone, listaEmail });
                }
                this.props.history.push("/app");
            } catch (err) {
                console.log(err);
                this.setState({ error: "Ocorreu um erro ao salvar o cliente" });
            }
        }
    };

    onChangeCEP = async (e) => {
        var cep = e.target.value;
        if (cep && cep.length === 8) {
            try {
                const response = await axios.get('https://viacep.com.br/ws/'+this.state.cep+'/json/');
                const { logradouro, complemento, bairro, localidade, uf } = response.data;
                this.setState({ logradouro, complemento, bairro, cidade: localidade, uf });
            
            } catch (error) {
                console.log(error);
            }
        }
    }

    handleTelefoneNumeroChange = id => e => {
        const listaTelefone = this.state.listaTelefone.map((telefone, i) => {
            if (id !== i) return telefone;
            return { ...telefone, numero: e.target.value };
        })
        this.setState({ listaTelefone });
    }
    handleTelefoneTipoChange = id => e => {
        const listaTelefone = this.state.listaTelefone.map((telefone, i) => {
            if (id !== i) return telefone;
            return { ...telefone, tipo: e.target.value };
        })
        this.setState({ listaTelefone });
    }

    handleAddTelefone = () => {
        this.setState({ listaTelefone: this.state.listaTelefone.concat([ { numero: "", tipo: "" } ]) });
    }

    handleRemoveTelefone = id => () => {
        var listaTelefone = this.state.listaTelefone.slice();
        listaTelefone.splice(id, 1)
        this.setState({ listaTelefone });
    }



    handleEmailChange = id => e => {
        const listaEmail = this.state.listaEmail.map((email, i) => {
            if (id !== i) return email;
            return { ...email, email: e.target.value };
        })
        this.setState({ listaEmail });
    }

    handleAddEmail = () => {
        this.setState({ listaEmail: this.state.listaEmail.concat([ { email: "" } ]) });
    }

    handleRemoveEmail = id => () => {
        var listaEmail = this.state.listaEmail.slice();
        listaEmail.splice(id, 1)
        this.setState({ listaEmail });
    }

    render() {
        return (
        <Container>
            <Form onSubmit={this.handleEdit}>
                <h2>{this.state.id ? "Editar Cliente" : "Novo Clinte"}</h2>
                {this.state.error && <p>{this.state.error}</p>}
                <div className="row">
                    <div className="col-md-8">
                        <div className="form-group">
                            <label>Nome: </label>
                            <input type="text" className="form-control" value={this.state.nome} onChange={e => this.setState({ nome: e.target.value })}
                                    maxLength="100" minLength="3" />
                        </div>
                    </div>
                    <div className="col-md-4">
                        <div className="form-group">
                            <label>Cpf: </label>
                            <input type="text" className="form-control" value={this.state.cpf} onChange={e => this.setState({ cpf: e.target.value })} 
                                    maxLength="11"/>
                        </div>
                    </div>
                </div>
                <div className="row">
                    <div className="col-md-3">
                        <div className="form-group">
                            <label>Cep: </label>
                            <input type="text" className="form-control" value={this.state.cep} onChange={e => this.setState({ cep: e.target.value })} onKeyUp={this.onChangeCEP.bind(this)} 
                                    maxLength="8" />
                        </div>
                    </div>
                    <div className="col-md-6">
                        <div className="form-group">
                            <label>Logradouro: </label>
                            <input type="text" className="form-control" value={this.state.logradouro} onChange={e => this.setState({ logradouro: e.target.value })} 
                                    maxLength="100"/>
                        </div>
                    </div>
                    <div className="col-md-3">
                        <div className="form-group">
                            <label>Complemento: </label>
                            <input type="text" className="form-control" value={this.state.complemento || ''} onChange={e => this.setState({ complemento: e.target.value })}
                                    maxLength="100" />
                        </div>
                    </div>
                </div>
                <div className="row">
                    <div className="col-md-3">
                        <div className="form-group">
                            <label>Bairro: </label>
                            <input type="text" className="form-control" value={this.state.bairro} onChange={e => this.setState({ bairro: e.target.value })}
                                    maxLength="100" />
                        </div>
                    </div>
                    <div className="col-md-3">
                        <div className="form-group">
                            <label>Numero: </label>
                            <input type="text" className="form-control" value={this.state.numero} onChange={e => this.setState({ numero: e.target.value })} 
                                    maxLength="45"/>
                        </div>
                    </div>
                    <div className="col-md-3">
                        <div className="form-group">
                            <label>Cidade: </label>
                            <input type="text" className="form-control" value={this.state.cidade} onChange={e => this.setState({ cidade: e.target.value })} 
                                    maxLength="100"/>
                        </div>
                    </div>
                    <div className="col-md-3">
                        <div className="form-group">
                            <label>Uf: </label>
                            <input type="text" className="form-control" value={this.state.uf} onChange={e => this.setState({ uf: e.target.value })}
                                    maxLength="2" />
                        </div>
                    </div>
                </div>
                <div className="row">
                    <div className="col-md-6">
                        { this.state.listaTelefone.map((object, id) => (
                            <div key={id} className="form-row align-items-center">
                                <div className="col-auto">
                                    <div className="form-group">
                                        <label>Telefone: </label>
                                        <input type="text" className="form-control" value={object.telefone} onChange={this.handleTelefoneNumeroChange(id)} />
                                    </div>
                                </div>
                                <div className="col-auto">
                                    <select className="form-control" value={object.tipo} onChange={this.handleTelefoneTipoChange(id)} >
                                        <option value=""></option>
                                        <option value="comercial">Comercial</option>
                                        <option value="residencial">Residencial</option>
                                        <option value="celular">Celular</option>
                                    </select>
                                </div>
                                <div className="col-auto">
                                    { id === 0 && <button type="button" className="btn btn-primary" onClick={this.handleAddTelefone} >Add</button> }
                                    { id !== 0 && <button type="button" className="btn btn-danger" onClick={this.handleRemoveTelefone(id)} >Ex</button> }
                                </div>
                            </div>
                            
                        )) }
                    </div>
                    <div className="col-md-6">
                        { this.state.listaEmail.map((object, id) => (
                            <div key={id} className="form-row align-items-center">
                                <div className="col-auto">
                                    <div className="form-group">
                                        <label>Email: </label>
                                        <input type="text" className="form-control" value={object.email} onChange={this.handleEmailChange(id)} />
                                    </div>
                                </div>
                                <div className="col-auto">
                                    { id === 0 && <button type="button" className="btn btn-primary" onClick={this.handleAddEmail} >Add</button> }
                                    { id !== 0 && <button type="button" className="btn btn-danger" onClick={this.handleRemoveEmail(id)} >Ex</button> }
                                </div>
                            </div>
                            
                        )) }
                    </div>
                </div>
                <div className="row">
                    <div className="col-md-12">
                        <div className="form-group">
                            <input type="submit" value="Salvar" className="btn btn-primary"/>
                        </div>
                        <Link to="/app">Cancelar</Link>
                        {/* <button type="button" className="btn btn-primary" onClick={this.addTelefone} >Add</button> */}
                    </div>
                </div>
            </Form>
        </Container>
        );
    }
}

export default withRouter(Edit);
