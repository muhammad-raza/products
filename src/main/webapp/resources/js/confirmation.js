require(['jquery', 'underscore', 'backbone', 'js/channels', 'js/basketItem'], function($, _, Backbone, ChannelList, BasketItem){
    var Channels = new ChannelList;

	var ConfirmationPage = Backbone.View.extend({
		el: $("#catalogues"),

		initialize: function() {
		    this.basketEl = $('#basket');
            this.listenTo(Channels, 'add', this.addOne);
            Channels.fetch();
		},

		addOne: function(channel) {
		    var basket = new BasketItem({model: channel});
		    this.basketEl.append(basket.render().el);
		}
	});

	var Confirmation = new ConfirmationPage;

});
