require.config({
    baseUrl: "../resources",
    paths: {
        jquery: "../resources/bower_components/jquery/dist/jquery",
        underscore:"../resources/bower_components/underscore/underscore",
        backbone:"../resources/bower_components/backbone/backbone",
        localStorage: "../resources/bower_components/backbone.localstorage/backbone.localStorage"
    },
    shim: {
    	jquery: {
    		exports: '$'
    	},
    	underscore: {
    		exports: '_'
    	},
    	localStorage: {
    		exports: 'Storage'
    	},
    	backbone: {
    		exports: 'Backbone',
    		deps: ['jquery', 'underscore']
    	}
    }
});