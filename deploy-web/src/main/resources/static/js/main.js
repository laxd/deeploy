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

	$("#executor-modal").on("click", "#save-executor", function() {
		// TODO get id and use that instead.
		var url = "/flow/1/step/add/" + $("#type").val();

		var data = $(".executor-argument").serialize();

		$.ajax({
			type: 'POST',
			url: url,
			data: data,
			success: function() {
				console.log("Added step!");
				$(".modal").modal('hide');
			},
			fail: function() {
				console.log("Failed to add step!");
			}
		});
	});

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