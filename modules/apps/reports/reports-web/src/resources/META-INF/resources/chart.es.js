import Chart from 'reports-web/js/Chart';
import randomColor from 'reports-web/js/randomColor';


class Chart {
    constructor() {
	}

	renderChart(container, config) {
        new Chart(
            container, 
            config
        );
	}
    
    getColors(count) {
        randomColor({luminosity: 'light',count: count});
    }
		
}

export default Chart;
