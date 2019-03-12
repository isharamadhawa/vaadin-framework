package com.gmail.ishara.ui.views.storefront.events;

import com.vaadin.flow.component.ComponentEvent;
import com.gmail.ishara.ui.views.orderedit.OrderItemEditor;

public class DeleteEvent extends ComponentEvent<OrderItemEditor> {
	public DeleteEvent(OrderItemEditor component) {
		super(component, false);
	}
}