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
        let { quantity } = this.state;
       // const quantity = this.state.quantity;
        //const text = this.state.text;
        quantity = quantity + 1;

        this.setState( { quantity });
    }

    render() {
        return (
            <>
                <div className="col-3">
                    <div className="input-group col-sm-6">
                        {this.state.quantity}
                        <input type="text" className="form-control" placeholder="Recipient's username"
                               aria-label="Recipient's username with two button addons"/>
                        <button className="btn btn-outline-secondary"
                                type="button"
                                onClick={this.onHandlingAddQuantity}>Add</button>
                    </div>
                </div>
            </>
        );
    }
}
