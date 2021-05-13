import React from "react";
import Item from "./Item";
import ItemLifeCycleHooks from "./ItemLifeCycleHooks";

export default class Items extends React.Component {

    constructor(props, context) {
        super(props, context);

        this.state = {
            items: [
                {id: 1, text: '', quantity: 0, isItemTextVisible: false},
                {id: 2, text: '', quantity: 0, isItemTextVisible: false},
                {id: 3, text: '', quantity: 0, isItemTextVisible: false},
                {id: 4, text: '', quantity: 0, isItemTextVisible: false}
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
                item.isItemTextVisible = true;
            }
            return item;
        });

        this.setState({items});
    }

    onHandlingHideText = (id) => {
        const items = this.state.items.map(item => {
            if (item.id === id) {
                item.isItemTextVisible = false;
            }
            return item;
        });

        this.setState({items});
    }

    render() {
        return (
            <>
                <ItemLifeCycleHooks timeOut={2000}/>
                {
                    this.state.items.map(item => <Item key={item.id}
                                                       item={item}
                                                       onHandlingItemText={this.onHandlingItemText}
                                                       onHandlingAddQuantity={this.onHandlingAddQuantity}
                                                       onHandlingRemoveQuantity={this.onHandlingRemoveQty}
                                                       onHandlingHideText={this.onHandlingHideText}/>)
                }
            </>
        );
    }
}
