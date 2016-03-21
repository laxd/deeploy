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

	var url = "/executor/modal?type=" + buildFlowType;

	 //Do ajax to get modal
	$.ajax({
		url: url,
		success: showModalWithHtml
	});
}

function showModalWithHtml(data) {
	var m = $("#executor-modal");
	m.empty();
	m.append(data);
	m.find(".modal").modal('show');
}