import React from "react";
import ItemBadge from "./ItemBadge";

export default class Item extends React.Component {
    render() {
        return (
            <>
                <div className="col-3">
                    <div className="input-group col-sm-6">
                        <ItemBadge quantity={this.props.item.quantity}/>
                        <input type="text" className="form-control" placeholder="Recipient's username"
                               aria-label="Recipient's username with two button addons"
                               onChange={(event) => this.props.onHandlingItemText(event, this.props.item.id)}/>
                        <button className="btn btn-outline-secondary"
                                type="button"
                                onClick={() => this.props.onHandlingAddQuantity(this.props.item)}>+
                        </button>
                        <button className="btn btn-outline-secondary"
                                type="button"
                                onClick={() => this.props.onHandlingRemoveQuantity(this.props.item)}>-
                        </button>
                    </div>
                    {this.props.item.text.length > 0 && <span>{this.props.item.text}</span>}
                </div>
            </>
        );
    }
}
