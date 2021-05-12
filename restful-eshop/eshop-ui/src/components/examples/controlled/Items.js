import React from "react";
import Item from "./Item";

export default class Items extends React.Component {

    constructor(props, context) {
        super(props, context);

        this.state = {
            items: [
                {id: 1, text: '', quantity: 0},
                {id: 2, text: '', quantity: 0},
                {id: 3, text: '', quantity: 0},
                {id: 4, text: '', quantity: 0}
            ]
        }
    }

    onHandlingAddQuantity = (item) => {
        const items = [...this.state.items];
        const index = items.indexOf(item);
        items[index] = {...item};
        items[index].quantity++;

        this.setState({items});
    }

    onHandlingRemoveQty = (item) => {
        const items = [...this.state.items];
        const index = items.indexOf(item);
        items[index] = {...item};
        items[index].quantity--;

        this.setState({items});
    }

    onHandlingItemText = (event, id) => {
        const items = this.state.items.map(item => {
            if (item.id === id) {
                item.text = event.target.value;
            }
            return item;
        });

        this.setState({items});
    }

    render() {
        return (
            <>
                {
                    this.state.items.map(item => <Item key={item.id}
                                                       item={item}
                                                       onHandlingItemText={this.onHandlingItemText}
                                                       onHandlingAddQuantity={this.onHandlingAddQuantity}
                                                       onHandlingRemoveQuantity={this.onHandlingRemoveQty}/>)
                }
            </>
        );
    }
}
