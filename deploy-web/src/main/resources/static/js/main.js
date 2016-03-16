$(document).ready(function() {
	$(".add-build-flow-step").on("click", function() {
		console.log("Showing add build flow step dialog...");
	});

	$("#steps").sortable({
		revert: true,
		accept: "#executor",
		receive: showAddBuildFlowModal
	});

	$(".executor").draggable({
		connectToSortable: "#steps",
		helper: "clone"
	}).disableSelection();

});

function showAddBuildFlowModal(event, ui) {
	var buildFlowType = ui.item.data('type');

	console.log("Showing modal for " + buildFlowType);

	var url = "/modal/executor?type=" + buildFlowType;

	// Do ajax to get modal
	$.ajax({
		url: url,
		success: function(data) {
			var modal = $("#modal");
			modal.replace(data);
			modal.attr("hidden", false);
			modal.dialog({
				modal: true,
				show: true
			})
		}
	});

}