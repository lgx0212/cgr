const webpack = require('webpack')
module.exports = {
  publicPath:'./',
	configureWebpack: {
		resolve: {
			alias: {
				'views': '@/views',
				'components': '@/components',
				'network': '@/network',
				'common': '@/common',
				'assets': '@/assets',
			}
		}
	},
chainWebpack: config => {
  config.plugin('provide').use(webpack.ProvidePlugin, [{
    $: 'jquery',
    jquery: 'jquery',
    jQuery: 'jquery',
    'window.jQuery': 'jquery'
  }])
}

}
