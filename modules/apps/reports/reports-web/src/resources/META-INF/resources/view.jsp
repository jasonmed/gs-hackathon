
<div id="<portlet:namespace />chartContainer">
</div>
 
<aui:script require="reports-web/chart.es" sandbox="true">
    var Chart = repotsWebChartEs.default;
    
    var chart = new Chart();
    
    var colors = chart.getColors(<%= users.size() %>);
    var displayContainer = document.getElementById('<portlet:namespace />chartContainer');
    
    var labels = [];    
    var data = [];
    
    <%
    for (User user : users) {
    %>
    labels.push("<%= user.getFullName() %>");
    <%
    }
    %>
    
    <%
    for (User user : users) {
    %>
    data.push("<%= userHours %>");
    <%
    }
    %>
    
    var data = {
        labels: labels,
        datasets: [
            {
                data: [300, 50, 100],
                backgroundColor: colors,
                hoverBackgroundColor: colors
            }
        ]
    };
    
    var chartData = {
        type: "doughnut",
        data: data
    }

	chart.renderChart(displayContainer, chartData);
</aui:script>
