$(document).ready(function() {
	$(".add-build-flow-step").on("click", function() {
		console.log("Showing add build flow step dialog...");
	});

	//$(".executor").on("click", function() {
	//	var url = "/modal/executor?type=SSH";
	//	$.ajax({
	//		url: url,
	//		success: function(data) {
	//			$("#modal").replace(data);
    //
	//			$("#modal").dialog({
	//				modal: true,
	//				show: true
	//			})
	//		}
	//	})
	//});

	$("#steps, #executors").sortable({
		connectWith: "#steps",
		receive: showAddBuildFlowModal
	}).disableSelection();

	//$(".executor").draggable({
	//	cursor: 'move',
	//	revert: true,
	//	clone: true
	//});
    //
	//$("#add-new-build-flow-step").droppable({
	//	accept: ".executor",
	//	drop: showAddBuildFlowModal
	//});
});

function showAddBuildFlowModal(event, ui) {
	var buildFlowType = ui.item.data('type');

	console.log("Showing modal for " + buildFlowType);
}