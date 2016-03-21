define(['jquery', 'underscore', 'backbone'], function($, _, Backbone){

	var BasketItem = Backbone.View.extend({
        tagName: 'li',
        template: _.template("<%= name %>"),

        initialize: function() {
            this.listenTo(this.model, 'destroy', this.remove);
        },

        render: function() {
            var channel = this.model.toJSON();
            this.$el.html(this.template(channel));
            $('#'+channel.id).attr('checked', true);
            return this;
        }
	});
	return BasketItem;
});
