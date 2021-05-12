import React from "react";

export default class Item extends React.Component {

    constructor(props, context) {
        super(props, context);

        this.state = {
            text: '',
            quantity: 0
        }
    }

    onHandlingAddQuantity = () => {
        let {quantity} = this.state;
        // const quantity = this.state.quantity;
        //const text = this.state.text;
        quantity = quantity + 1;

        this.setState({quantity});
    }

    onHandlingRemoveQty = () => {
        const quantity = this.state.quantity - 1;
        this.setState({quantity});
    }

    onHandlingItemText = (event) => {
        const text = event.target.value;
        this.setState( {text});
    }

    getBadgeClass() {
        let badgeClass = "m-2 badge bg-";
        if (this.state.quantity > 2) {
            badgeClass += "success";
        } else if (this.state.quantity < 0) {
            badgeClass += "danger";
        } else {
            badgeClass += "secondary";
        }

        return badgeClass;
    }

    render() {
        return (
            <>
                <div className="col-3">
                    <div className="input-group col-sm-6">
                        <div className={this.getBadgeClass()}>{this.state.quantity}</div>
                        <input type="text" className="form-control" placeholder="Recipient's username"
                               aria-label="Recipient's username with two button addons"
                               onChange={this.onHandlingItemText}/>
                        <button className="btn btn-outline-secondary"
                                type="button"
                                onClick={this.onHandlingAddQuantity}>+
                        </button>
                        <button className="btn btn-outline-secondary"
                                type="button"
                                onClick={this.onHandlingRemoveQty}>-
                        </button>
                    </div>
                    {this.state.text.length > 0 && <span>{this.state.text}</span>}
                </div>
            </>
        );
    }
}
