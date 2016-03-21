define(['jquery', 'underscore', 'backbone', 'js/channel', 'localStorage'], function($, _, Backbone, Channel){
	
	var ChannelList = Backbone.Collection.extend({
		model: Channel,
		localStorage: new Backbone.LocalStorage('channel')

	});
	return ChannelList;
});