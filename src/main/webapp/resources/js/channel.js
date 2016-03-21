define(['jquery', 'underscore', 'backbone'], function($, _, Backbone){

	var Channel = Backbone.Model.extend({
		defaults: function(){
			return {
				id: '',
				name: '',
				customerID: ''
			}
		}
	});

	return Channel;
});