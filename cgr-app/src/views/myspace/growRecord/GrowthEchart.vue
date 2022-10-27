<template>
<div>
  <div id="main" style="width: 320px;height: 320px;"></div>
</div>
</template>

<script>
  import echarts from "echarts";

  export default {
    name: "GrowthEchart",
    props:{
      growthData:{
        type:Array
      },
      growthKey:{
        type:Array
      }
    },
    data() {
      return {
        charts: '',
        opinionData: ["3", "2", "4", "4"]
      }
    },
    methods: {
      drawLine(id) {
        this.charts = echarts.init(document.getElementById(id))
        this.charts.setOption({
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            data: ['身高']
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },

          toolbox: {
            feature: {
              saveAsImage: {}
            }
          },
          xAxis: {
            type: 'category',
            boundaryGap: false,
            data: this.growthKey
          },
          yAxis: {
            type: 'value'
          },

          series: [{
            name: '身高',
            type: 'line',
            stack: '总量',
            data: this.growthData
          }]
        })
      }
    },
    //调用
    // mounted() {
    //   this.$nextTick(function() {
    //
    //     console.log(this.growthData)
    //     this.drawLine('main')
    //   })
    // },
    watch: {
      growthData: {
        handler(newval, oldval) {
          if(newval) {
            this.drawLine('main')
          }
          return newval
        },
        deep: true
      }
    }
  }
</script>

<style scoped>

</style>
