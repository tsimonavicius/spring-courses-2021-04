import React from "react";

export default class Item extends React.Component {

    getBadgeClass() {
        let badgeClass = "m-2 badge bg-";
        if (this.props.item.quantity > 2) {
            badgeClass += "success";
        } else if (this.props.item.quantity < 0) {
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
                        <div className={this.getBadgeClass()}>{this.props.item.quantity}</div>

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
