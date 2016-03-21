require(['jquery', 'underscore', 'backbone', 'js/channels', 'js/basketItem'], function($, _, Backbone, ChannelList, BasketItem){
    var Channels = new ChannelList;

	var CataloguesApp = Backbone.View.extend({
		el: $("#catalogues"),

		events: {
			"change [type='checkbox']":  "onCheckboxChange"
		},

		initialize: function() {
		    this.basketEl = $('#basket');
            this.listenTo(Channels, 'add', this.addOne);
            this.listenTo(Channels, 'remove', this.removeOne);
            this.customerID = this.$el.attr('data-id');
            Channels.fetch();
		},

		addOne: function(channel) {
            if (channel.toJSON().customerID === this.customerID) {
                var basket = new BasketItem({model: channel});
                this.basketEl.append(basket.render().el);
            }
		},

		removeOne: function(channel) {
            channel.destroy();
        },

		onCheckboxChange: function(evt) {
		    if (evt.target.checked){
                Channels.create({id: evt.target.id, name: evt.target.value, customerID: this.customerID});
            }else {
                Channels.remove(evt.target.id);
            }
    	}
	});

	var Catalogues = new CataloguesApp;

});
